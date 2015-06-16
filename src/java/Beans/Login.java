/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPSearchResults;
import java.io.UnsupportedEncodingException;

public class Login {

    private LDAPConnection lc;

    public Login() {
        lc = new LDAPConnection();

    }

    public String login(String cedula, String contrasena) throws LDAPException {

        String nombreUsuario = buscar(cedula);
        System.out.println("Nombre completo" + nombreUsuario);
        if (nombreUsuario.equals("No hay usuarios con la cedula solicitada")) {
            return nombreUsuario;
        }
        if (nombreUsuario.equals("ERROR al conectarse al Servidor LDAP")) {
            return nombreUsuario;
        } else {
            return usuario(nombreUsuario, contrasena);
        }
    }

    public String usuario(String nombreUsuario, String contrasena) {
        System.out.println("DATOS ---> " + nombreUsuario + " - " + contrasena);
        if (conectar()) {
            if (validarContrasena(nombreUsuario, contrasena)) {
                return "Login exitoso";
            } else {
                return "El usuario y la contraseÃ±a no corresponden";
            }
        } else {
            return "Conexion al Servidor LDAP fallida";
        }

    }

    public Boolean conectar() {

        String ldapHost = "192.168.0.18";
        String dn = "cn=admin,dc=arqsoft,dc=com";
        String password = "arqsoft2015";

        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("====Conectado al Servidor LDAP====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("====Autenticado en el servidor====");
            return true;
        } catch (Exception ex) {
            System.out.println("====ERROR al conectarse al Servidor LDAP====");
            return false;

        }
    }

    public Boolean validarContrasena(String nombreUsuario, String contrasena) {

        String dn = "cn=" + nombreUsuario + ",ou=BusesUrbanos,dc=arqsoft,dc=com";
        try {
            lc.bind(dn, contrasena);
            System.out.println("====Contrasena Validada====");
            return true;
        } catch (LDAPException ex) {
            System.out.println("====ERROR al validar la contrasena====");
            System.out.println(ex);
            return false;
        }

    }

    public String buscar(String cedula) throws LDAPException {
        if (!this.conectar()) {
            return "ERROR al conectarse al Servidor LDAP";
        }
        String searchBase = "ou=BusesUrbanos,dc=arqsoft,dc=com";
        int searchScope = LDAPConnection.SCOPE_ONE;
        String searchFilter = "(cn=" + cedula + ")";

        LDAPSearchResults searchResults
                = lc.search(searchBase,
                        searchScope,
                        searchFilter,
                        null,
                        false);

        if (searchResults.hasMore()) {
            LDAPEntry nextEntry = null;

            try {

                nextEntry = searchResults.next();

            } catch (LDAPException e) {

                System.out.println("Error: " + e.toString());

            }
            this.lc.disconnect();

            return nextEntry.getAttribute("cn").getStringValue();

        } else {
            this.lc.disconnect();
            return "No hay usuarios con la cedula solicitada";
        }

    }

    public String addUserLDAP(String cedula, String nombre, String password) throws LDAPException {
        this.conectar();
        //String result = this.buscar(cedula);
       /* if(!result.equals("No hay usuarios con la cedula solicitada")){
         System.out.println("La cedula ya existe");
         this.lc.disconnect();
         return "La cedula ya existe";
        
         }*/
        String containerName = "ou=BusesUrbanos,dc=arqsoft,dc=com";
        LDAPAttribute attribute = null;

        LDAPAttributeSet attributeSet = new LDAPAttributeSet();
        attributeSet.add(new LDAPAttribute(
                "objectclass", new String("inetOrgPerson")));

        attributeSet.add(new LDAPAttribute("givenname",
                new String[]{nombre}));

        attributeSet.add(new LDAPAttribute("sn", nombre));

        attributeSet.add(new LDAPAttribute("uid", nombre));

        attributeSet.add(new LDAPAttribute("userpassword", password));

        String dn = "cn=" + cedula + "," + containerName;

        LDAPEntry newEntry = new LDAPEntry(dn, attributeSet);

        try {
            lc.add(newEntry);
            System.out.println("El usuario ha sido creado");

        } catch (LDAPException e) {

            System.out.println("Error:  " + e.toString());

        }

        this.lc.disconnect();
        return "LDAP finaliza peticion";
    }

}
