package org.codecomrades.Repository;

import java.sql.SQLException;

public interface EmpRepo {
    public boolean register() throws SQLException;
    public boolean updateEmp();
    public boolean deleteEmp();

}
