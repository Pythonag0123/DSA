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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> ls=new ArrayList<>();
        ListNode a=head;
        while(a!=null){
            ls.add(a.val);
            a=a.next;
        }
        int[] ans=new int[ls.size()];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<ls.size();i++){
            while(!st.isEmpty() && ls.get(st.peek())<ls.get(i)){
                ans[st.pop()]=ls.get(i);
            }
            st.push(i);
        }
        return ans;
        
        
    }
}