/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        for(int i =0; ; i++)
        {
            if(i % 1000 == 0) Thread.sleep(100);
            Class c = cp.makeClass("test"+i).toClass();
        }
        
        
    }
}