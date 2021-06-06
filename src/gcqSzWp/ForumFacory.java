package gcqSzWp;

public class ForumFacory {
	private static Object initLock = new Object();
	private static String className="com.jivesoftware.forum.database.DbForumFactory";
	private staticForumFactory  factory = null;
	public static ForumFacoty getInstance(Authorization authorization) {
		if(authorization == null) {
			return null;
		}
		if(facorty == null) {
			synchronized(initLock) {
				if(factory == null) {
					try {
						Class c = Class.forName(className);
						factory =(ForumFactory)c.newInstance();
					}catch(Exception e) {
						return null;
					}
					
				}
			}
		}
		return new ForumFactoryProxy(authorization,factory,factory.getPermissions(authorization));
	}
	
	
	public abstract Forum createForum(String name,String description)
	throws UnauthorizedException,ForumAlreadyExistsException;

}
