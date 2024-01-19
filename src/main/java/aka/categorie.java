package aka;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	public class categorie {
	    private int id;
	    private String libelle;

	    // Constructors, getters, and setters

	    public static List<categorie> getAllCategories() {
	        List<categorie> categories = new ArrayList<>();

	        try (Connection conn = Connect.createConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM categorie")) {

	            while (rs.next()) {
	                categorie categorie = new categorie();
	                categorie.setId(rs.getInt("IdCategorie"));
	                categorie.setLibelle(rs.getString("libelle"));
	                categories.add(categorie);
	            }

	        } catch (Exception e) {
	            e.printStackTrace(); // Handle the exception appropriately
	        }

	        return categories;
	    }

		public  void setId(int id) {
		
			this.id=id;
		}
		public void setLibelle(String libelle) {
			this.libelle=libelle;
		}
		public int getId() {
			return this.id;
		}
		public String getLibelle() {
			return this.libelle;
		}
	    // Other methods, getters, and setters
	}



