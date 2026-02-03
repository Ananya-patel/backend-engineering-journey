//two pointer approach  and inplace reverse of a string 
public class ReverseString{
    public static String reverse(String s ){
        char[] arr=s.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}

// now through string builder 
//public class ReverseString{
//    public static String reverse(String s ){
//        StringBuilder sb=new StringBuilder(s);
//        return sb.reverse().toString();
//    }
//    public static void main(String[] args) {
//        System.out.println(reverse("hello"));
//    }

// comparing time complexity of both approaches
// In-place two-pointer approach:
// Time Complexity: O(n), where n is the length of the string. We traverse half
// of the string to swap characters.
// Space Complexity: O(1) if we ignore the space used for the input string
// StringBuilder approach:
// Time Complexity: O(n), where n is the length of the string. The reverse()
// method traverses the entire string.
// Space Complexity: O(n) because StringBuilder creates a new character array
// to hold the reversed string.
//}