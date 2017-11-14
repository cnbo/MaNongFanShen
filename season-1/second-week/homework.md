## 读取配置文件 struts.xml

```

public class Struts {
  public static View runAction(String actionName, Map<String, String> params) {
    /**
    0. 读取配置文件 struts.xml

    1. 根据 actionName 找到对应的 class，例如 LoginAction,通过反射实例化（创建对象），然后根据 params 中的数据，调用对象的 setter方法，例如 params 中的数据是 {"name"="cnbo", "password"="1234"},那就应该调用 setName 和 setPassword 方法

    2.通过反射调用对象的 exectue 方法，并获得返回值，例如 "success"

    3.通过反射找到对象的所有 getter 方法，通过反射来调用，把值和属性形成一个 HashMap，例如 {"message":"登录成功"}, 放到 View 对象的 parameters

    4.根据 struts.xml 中的 <result> 配置，以及 execute 的返回值，确定哪一个 JSP，放到 View 对象的 jsp 中
    */
  }

  public class View {
    String jsp;
    Map<String, String> parameters;
  }
}

```

## 数据结构

```

public class ArrayUtil {
  /**
  给定一个整形数组 a,该数组的值进行置换
  例如：a = [7, 9, 30, 3]，置换后为 [3, 30, 9, 7]
  如果： a = [7, 9, 30, 3, 4]，置换后为 [4, 3, 30, 9, 7]
  */
  public void reverseArray(int[] origin) {

  }

  /**
  现在有如下的一个数组；int oldArr[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5}
  要求将以上数组中为 0 的项去掉，将不为 0 的值存入一个新的数组，生成的新数组为：{1, 3, 4, 5, 6, 6, 5, 4, 7, 6, 7, 5}
  */
  public int[] removeZero(int[] oldArray) {

  }

  /**
  给定两个已经排序号的整形数组， a1 和 a2，创建一个新的数组 a3，使得 a3 包含 a1 和 a2 的所有元素
  例如： a1 = [3, 5, 7, 8] a2 = [4, 5, 6, 7]
  则 a3 为 [3, 4, 5, 6, 7, 8]
  */

  public int[] merge(int[] array1, int[] array2) {

  }

  /**
  把一个已经存满数据的数组 oldArray 的容量进行扩展，扩展后的数据大小为 oldArray.length
  注意，老数组的元素在新数组中需要保持
  例如 oldArray = [2, 3, 5], size = 3, 则返回的数组为
  [2, 3, 5, 0, 0, 0]
  */
   public int grow(int[] oldArray, int size) {

   }

   /**
   斐波拉契数列为：1, 1, 2, 3, 5, 8, 13, 21...
   给定一个最大值，返回小于该值得数列
   例如： max = 15, 则返回的数组应该为 [1, 1, 2, 3, 5, 8, 13]
   max = 1, 则返回空数组 []
   */
   public int[] fibonacci(int max) {

   }

   /**
   返回小于给定最大值 max 的所有素数数组
   例如 max = 23，返回的数组为 [2, 3, 5, 7, 11, 13, 17, 19]
   */
   public iint[] getPrimes(int max) {
     return null;
   }

   /**
   所谓“完数”，是指这个数恰好等于它的因子之和，例如 6 = 1 + 2 + 3
   给定一个最大值 max,返回一个数组，数组中是小于 max 的所有完数
   */
   public int[] getPerfectNumbers(int max) {
     return null;
   }

   /**
   用seperator 把数组 array 给连接起来
   例如 rray = [3, 8, 9], seperator = "-"
   则返回值为 "3-8-9"
   */
   public String join(int[] array, String swperator) {
     return null;
   }

}

```

