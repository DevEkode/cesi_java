package ListObjects;

import BDD.Person;

public class PersonItem {

    private int id;
    private String login;

    public PersonItem(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return getLogin();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PersonItem){
            PersonItem p = (PersonItem) obj;
            return p.getId() == this.getId();
        }
        return false;
    }
}
