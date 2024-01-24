package objet;

import java.util.Vector;

import generalisation.Generalisation;

public class Role {
    String id_role;
    String id_grade;
    String role;

    public String getId_grade() {
        return id_grade;
    }

    public void setId_grade(String id_grade) {
        this.id_grade = id_grade;
    }
    
    public String getId_role() {
        return id_role;
    }
    public void setId_role(String id_role) throws Exception{
        if (id_role==null || id_role.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : id_role invalid");
        }
        this.id_role = id_role;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) throws Exception{
        if (role==null || role.equals("")) {
            throw new Exception( this.getClass().getSimpleName() + " : role invalid");
        }
        this.role = role;
    }
    public void insert_Role(String role) throws Exception{
		findInBase(role);
		Role newRole = new Role();
		newRole.setId_role(Generalisation.generatePrimaryKey("RL" , "seq_" + this.getClass().getSimpleName()));
        newRole.setRole(role);
		Generalisation.insert(newRole);
	}
	public Vector<Role> convert_Role(Vector<Object> ob){
		Vector<Role> result = new Vector<>() ;
		for(Object obj : ob){
			if(obj instanceof Role){
				result.add((Role) obj);
			}
		}
		return result;
	}
	public Vector<Role> findAll() throws Exception{
		Vector<Object> vect = Generalisation.select("",this);
		Vector<Role> Roles = this.convert_Role(vect);
		return Roles;
	}
	public boolean findInBase(String role) throws Exception{
		Vector<Object> vect = Generalisation.select("where role = '" + role + "'", this);
		if(vect.isEmpty()){
			return true;
		}
		throw new Exception("This " +this.getClass().getSimpleName() + " is already in base.");
	}
    
}
