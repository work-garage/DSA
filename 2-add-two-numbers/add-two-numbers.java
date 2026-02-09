/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // IMP Q things to learn:
    // 1) Int, Long limits reach
    // 2) forward the carry of Sum
    

    // Approach 2) i) my Optimised Approach Code (But It can also be made short, look below for popular solution of it 2 ii))

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode temp = l;
        while(l1!=null && l2!=null){    //

            int n = temp.val+l1.val+l2.val;     // if x+y>9 then carry 1 forward
            temp.val = n%10;
            n/=10;
            
            if(l1.next!=null || l2.next!=null || n>0){      //condition for extra next node problem
                temp.next = new ListNode();
                temp=temp.next;
            }
            
            if(n>0) temp.val=1;             // took carry 1

            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int n = temp.val+l1.val;
            temp.val = n%10;
            n/=10;

            if(l1.next!=null || n>0){
                temp.next = new ListNode();
                temp=temp.next;
            }

            if(n>0) temp.val=1;             // took carry 1

            l1=l1.next;
        }
        while(l2!=null){
            int n = temp.val+l2.val;
            temp.val = n%10;
            n/=10;

            if(l2.next!=null || n>0){
                temp.next = new ListNode();
                temp=temp.next;
            }

            if(n>0) temp.val=1;             // took carry 1

            l2=l2.next;
        }

        return l;
    }
}



    //Approach 2 ii) popular optimised minimised solution


    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    //     ListNode dummy = new ListNode(0);
    //     ListNode temp = dummy;
    //     int carry = 0;

    //     while (l1 != null || l2 != null || carry != 0) {

    //         int sum = carry;

    //         if (l1 != null) {
    //             sum += l1.val;
    //             l1 = l1.next;
    //         }

    //         if (l2 != null) {
    //             sum += l2.val;
    //             l2 = l2.next;
    //         }

    //         carry = sum / 10;
    //         temp.next = new ListNode(sum % 10);
    //         temp = temp.next;
    //     }

    //     return dummy.next;
    // }










    // Approach 1 : Failed approach due to constraints given(too long number)


    //Below Approach wont work as given costraints overflow int,long limits

    // For these constraints, The number of nodes in each linked list is in the range [1, 100]
    //int,long or any oher variable cannot handle number with 100 digits.
    
    //Big takeaway (remember this for interviews)
    // If a problem gives numbers as linked lists
    // it’s a signal that numbers are too large to store normally

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     long n1=0;
    //     long n2=0;
    //     int i=0;
    //     while(l1!=null || l2!=null){
    //         if(l1!=null){
    //             n1+=l1.val*Math.pow(10,i);
    //             l1=l1.next;
    //         }

    //         if(l2!=null){
    //             n2+=l2.val*Math.pow(10,i);
    //             l2=l2.next;
    //         }
    //         i++;
    //     }

    //     long n3 = n1+n2;
    //     ListNode c3 = new ListNode();
    //     ListNode temp=c3;

    //     while(n3!=0){
    //         temp.val= (int) n3%10;
    //         n3/=10;

    //         if(n3!=0){
    //             temp.next = new ListNode();
    //             temp=temp.next;
    //         }
    //     }
    //     return c3;
    // }