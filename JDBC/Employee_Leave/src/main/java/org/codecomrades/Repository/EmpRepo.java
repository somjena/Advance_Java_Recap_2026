package org.codecomrades.Repository;

import java.sql.SQLException;

public interface EmpRepo {
    public boolean register() ;
    public boolean updateEmp();
    public boolean deleteEmp();
    public int getnewId();

}
