// 懒汉式
public class Singleton {

    // 加入了volatile 关键字，禁止指令重排
    private static volatile Singleton singleton = null;

    // 私有化构造器，防止被实例化
    private Singleton(){}


    private Singleton getSingleton(){

        // 多次调用getSingleton函数时，如果每次都进入synchronized会造成一个资源浪费问题
        if(singleton != null)  return singleton;

        //防止出现多线程安全问题
        synchronized (Singleton.class){
            if(singleton == null){
                singleton = new Singleton();
            }
        }
        
        return singleton;

    }




}
