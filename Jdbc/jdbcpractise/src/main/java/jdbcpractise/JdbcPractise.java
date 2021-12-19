package jdbcpractise;

public class JdbcPractise {

	public static void main(String args[]) throws Throwable {

		JdbcAction jd = new JdbcAction();
		jd.createConnection();
		jd.showData();
		jd.updateData();
		jd.showDataProcedure();
		jd.closeConnection();

	}

}
