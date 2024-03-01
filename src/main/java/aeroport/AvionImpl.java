package aeroport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AvionImpl implements IavionCatalogue {
@Override
public List<Avion> getAvionsParMotCle(String mc) {
 List<Avion> prods= new ArrayList<Avion>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from AVIONS where NOM_AVION LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Avion p = new Avion();
p.setIdAvion(rs.getLong("ID_AVION"));
p.setNomProduit(rs.getString("NOM_AVION"));
p.setPrix(rs.getDouble("PRIX"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public void addAvion(Avion a) {
// TODO Auto-generated method stub
}
}
