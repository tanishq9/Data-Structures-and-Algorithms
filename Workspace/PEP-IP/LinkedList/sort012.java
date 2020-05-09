package LinkedList;

public class sort012 {
	static Node segregate(Node head) {
		// 9 1 2 2 1 2 0 2 0 2
		Node zh = null, zt = null, oh = null, ot = null, th = null, tt = null;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 0) {
				if (zh == null) {
					zh = temp;
					zt = temp;
				} else {
					zt.next = temp;
					zt = temp;
				}
			} else if (temp.data == 1) {
				if (oh == null) {
					oh = temp;
					ot = temp;
				} else {
					ot.next = temp;
					ot = temp;
				}
			} else if (temp.data == 2) {
				if (th == null) {
					th = temp;
					tt = temp;
				} else {
					tt.next = temp;
					tt = temp;
				}
			}
			temp = temp.next;
		}
		// Assign head
		if (zh != null) {
			head = zh;
			// Make connections
			if (oh != null) {
				zt.next = oh;
				ot.next = th;
				if (th != null) {
					tt.next = null;
				}
			} else {
				zt.next = th;
				if (th != null) {
					tt.next = null;
				}
			}
			return zh;
		} else if (oh != null) {
			head = oh;
			ot.next = th;
			if (th != null) {
				tt.next = null;
			}
			return oh;
		} else if (th != null) {
			head = th;
			tt.next = null;
			return th;
		}
		return null;
	}
}
