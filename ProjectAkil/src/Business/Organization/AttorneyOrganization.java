/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AttorneyRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author AkilP
 */
public class AttorneyOrganization extends Organization {

    public AttorneyOrganization() {
        super(Organization.Type.Attorney.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AttorneyRole());
        return roles;
    }

}
