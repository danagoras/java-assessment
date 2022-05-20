// Please read Deloitte Social pdf before you start coding, thanks! //

public class Main {
  public static void main(String[] args) throws Exception {
    //
    // Examples
    //
    System.out.println(whoLikedMe(new String[] {})); // must be "no one likes this"
    System.out.println(whoLikedMe(new String[] { "John" })); // must be "John likes this"
    System.out.println(whoLikedMe(new String[] { "John", "Alicia" })); // must be "John and Alicia like this"
    System.out.println(whoLikedMe(new String[] { "John", "Alicia", "Mark" })); // must be "John, Alicia and Mark like this"
    System.out.println(whoLikedMe(new String[] { "John", "Alicia", "Mark", "Alex" })); // must be "John, Alicia and 2 others like this"

    System.out.println(complexId(454)); // 162516
    System.out.println(complexId(2233)); // 4499
    System.out.println(complexId(9118)); // 811164

    System.out.println(isValid(new char[] { 'n', 'e', 'w', 's' })); // false
    System.out.println(isValid(new char[] { 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's' })); // true
    System.out.println(isValid(new char[] { 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n' })); // false
    System.out.println(isValid(new char[] { 'n', 'e', 'w', 's', 'n', 'e', 'w', 's', 'n', 's' })); // true
  }

  public static String whoLikedMe(String... names) {
    // .. Your Code goes HERE .. //
    switch(names.length)
      {
        case 0:
          return "no one likes this";
        case 1:
          return names[0] + " likes this";
        case 2:
          return names[0] + " and " + names[1] + " like this";
        case 3: 
          return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        default: 
          return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
      }
  }

  public static int complexId(int postId) {
    // .. Your Code goes HERE .. //
    String str = Integer.toString(postId);
    int size = str.length();
    int[] array = new int[size];
    String ID="";
    for(int i=0; i<size; i++)
      {
        if(i ==0 )
        {
          array[i] = postId%((int)Math.pow(10, i+1));
        }
        else  
        {
          array[i] = (postId%((int)Math.pow(10, i+1)))/((int)Math.pow(10, i));
        }
      }
    for(int i=size-1; i>=0; i--)
      {
        ID += array[i]*array[i] + "";
      }
    return Integer.parseInt(ID);
  }

  public static boolean isValid(char[] steps) {
    // .. Your Code goes HERE .. //
    int[] counters = {0,0,0,0}; // tracks how mnany of each direction we have
    if(steps.length != 10)
    {
      return false;
    }
    else
    {
      for(int i=0; i<10; i++)
      {
        if(steps[i] == 'n')
        {
              counters[0]++;
        }
        else if(steps[i] == 's')
        {
              counters[1]++;
        }
        else if(steps[i] == 'w')
        {
              counters[2]++;
        }
        else if(steps[i] == 'e')
        {
              counters[3]++;
        }
      }
      if(counters[0] == counters[1] && counters[2] == counters[3])
      {
        return true;
      }
      else 
      {
        return false;
      }
    }
  }
}
