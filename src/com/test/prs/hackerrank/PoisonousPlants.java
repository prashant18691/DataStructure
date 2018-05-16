package com.test.prs.hackerrank;

import java.util.*;

/*public class PoisonousPlants {
    public static int solve(int[] p){
        Stack<LinkedList<Integer>> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < p.length; i++) {
            if (i>0 && p[i-1]>=p[i])
                list.add(p[i]);
            else {
                LinkedList<Integer> newlist = new LinkedList<>();
                newlist.add(p[i]);
                stack.push(newlist);
                list = newlist;
            }

        }
//        System.out.println(stack);
        int noOfDays = 0;
        while (stack.size()!=1) {
            for (int k = stack.size() - 1; k > 0; k--) {
                stack.get(k).removeFirst();
                if (stack.get(k).size()==0)
                    stack.remove(k);
                *//*
                LinkedList l = stack.get(k);
                l.removeFirst();
                if (l.size() == 0)
                    stack.remove(k);
                    *//*
            }
            mergeStack(stack);
            noOfDays++;
        }
        return noOfDays;
    }

    private static void mergeStack(Stack<LinkedList<Integer>> stack) {
        int i = stack.size()-1;
        while(i>0){
            LinkedList<Integer> curr = stack.get(i-1);
            LinkedList<Integer> next = stack.get(i);
            if (curr.get(curr.size()-1)>=next.get(0)){
                curr.addAll(next);
                stack.remove(i);
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int result = solve(p);
        System.out.println(result);
        in.close();
    }
}*/



public class PoisonousPlants {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] P = new int[N];
		for (int i = 0; i < P.length; i++) {
			P[i] = sc.nextInt();
		}
		System.out.println(solve(P));

		sc.close();
	}

	static int solve(int[] P) {
		List<LinkList> parts = new ArrayList<LinkList>();
		LinkList lastPart = null;
		for (int i = 0; i < P.length; i++) {
			if (i > 0 && P[i] <= P[i - 1]) {
				lastPart.append(P[i]);
			} else {
				LinkList part = new LinkList();
				part.append(P[i]);

				parts.add(part);
				lastPart = part;
			}
		}

		int day = 0;
		while (parts.size() > 1) {
			for (int i = 1; i < parts.size(); i++) {
				parts.get(i).removeFirst();
			}

			List<LinkList> nextParts = new ArrayList<LinkList>();
			for (LinkList part : parts) { //6>5, 4, null, 9
				if (part.head == null) {
					continue;
				}

				if (!nextParts.isEmpty() && nextParts.get(nextParts.size() - 1).tail.value >= part.head.value) {
					nextParts.get(nextParts.size() - 1).append(part);
				} else {
					nextParts.add(part);
				}
			}
			parts = nextParts;

			day++;
		}
		return day;
	}
}

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}
}

class LinkList {
	Node head;
	Node tail;

	void append(int value) {
		Node node = new Node(value);
		if (tail == null) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
	}

	void append(LinkList list) {
		tail.next = list.head;
		tail = list.tail;
	}

	void removeFirst() {
		head = head.next;
		if (head == null) {
			tail = null;
		}
	}
}

