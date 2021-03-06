import java.util.ArrayList;

public class GitDatabaseTester {
	
	public static void main (String[] args) {
		
		GitDatabase database = GitDatabase.getInstance();
		
		database.createNewFile("file2", "This is the second file for testing.");
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		database.save ("This is the first file for testing. Added a new line", "Add a new line");
//		System.out.println(database.retrieveFileRecordsFromDatabase("file2","This is the second file for testing."));
////		
////		database.save ("This is the Second file for testing. Added another new line", "Add another new line");
////		
		ArrayList<Commit> retrieves = database.retrieve();
		
		long lastCommitTime = 0;
		
		for (Commit commit: retrieves) {
			System.out.println(commit.getCommitMessage());
			lastCommitTime = commit.getCommitTime();
			System.out.println(lastCommitTime);
		}
		
		String content = database.openRetrievedVersion(lastCommitTime + "","This content");
		database.save(content, "saved after retrieving.");
//
//		System.out.println(database.openRetrievedVersion(lastCommitTime + "", "This is the Second file for testing. Added another new line"));
//		
		database.closeDatabase();
		

	}
}
