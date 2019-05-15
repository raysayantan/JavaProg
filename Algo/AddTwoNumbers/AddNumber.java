package algo.myprog;

public class AddNumber {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1,l2);
		Display(l3);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode p = null;
        int sum = 0;
        int carry = 0;
        int res = 0;
        
        while(l1 != null || l2 != null) {
        	int opnd1 = 0;
        	int opnd2 = 0;
        	opnd1 = (l1 != null)?l1.val:0;
        	opnd2 = (l2 != null)?l2.val:0;
        	res = l1.val + l2.val + carry;
        	sum = res%10;
        	carry = res/10;
        	
        	if(start == null) {
        		start = new ListNode(sum);
        		p = start;
        	} else {
        		p.next = new ListNode(sum);
        		p = p.next;
        	}
        	
        	if(null != l1) l1 = l1.next;
        	if(null != l2) l2 = l2.next;
        }
        
        if(carry > 0) {
        	p.next = new ListNode(carry);
        }
        
        return start;
    }
	
	public static void Display(ListNode l) {
		while(l != null) {
			System.out.print("->"+l.val);
			l = l.next;
		}
	}
}
