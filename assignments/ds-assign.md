1. Load employees data from emp.csv into ArrayList<Emp> and sort them using comparator as follows.
	a. in ascending order by name
	b. in descending order by job
	c. in ascending order by deptno and descending order of sal (if deptno is same).
		```Java
		// 1st deptno, 2nd sal, 3rd name
		int compare(Employee e1, Employee e2) {
			int diff = e1.getDeptNo() - e2.getDeptNo();
			if(diff == 0)
				diff = (int)Math.sign(e1.getSal() - e2.getSal());
			if(diff == 0)
				diff = e1.getName().compareTo(e2.getName());
			return diff;
		}
		```
2. Implement a selection sort algorithm for array of double variables. The function should return number of swappings.

3. Implement a generic bubble sort and insertion sort method. Method takes two arguments array of objects to be sorted and comparator object. Method should sort array contents based on comparator.
	```Java
	static <T> selectionSort(T[] arr, Comparator<T> cmp) {
		for(int i=0; i < arr.length-1; i++) {
			for(int j=i+1; j < arr.length; j++) {
				if( cmp.compare(arr[i], arr[j]) > 0 ) {
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	```

	```Java
	public static void main(String[] args) {
		String[] arr = {"", "", "", ""};
		selectionSort(arr, (x,y) -> x.compareTo(y));
	}
	```

4. Implement a doubly linked list of "java.lang.Object" with standard operations. Write a menu driven program to use the linked list to manage objects of user defined Person class.

5. Implement doubly circular linked list of any type, with following operations:
	a. addFirst()
	b. addLast()
	c. insertAtPos()
	d. delFirst()
	e. delLast()
	f. delAtPos()
	g. displayForward()
	h. displayReverse()

6. For a singly linked list of integers perform following operations:
	a. find middle node of list
	b. count number of integers matching given criteria -- pass Predicate<> object.
		```Java
		class SinglyList {
			// ...
			public int countMatching(Predicate<integers> pred) {
				Node trav = head;
				int count = 0;
				while(trav != null) {
					if(pred.test(trav.data))
						count++;
					trav = trav.next;
				}
			}
			return count;
		}
		class Main() {
			public static void main(String[] args) {
				// ...
				int cnt = list.countMatching(i -> i % 2 == 0);
				System.out.println("Count: " + cnt);
				// ...
			}
		}
		```
	c. reverse the linked list using recursion
	d. add difference of two consecutive nodes before them.
		input: 4 -> 7 -> 9 -> 1 -> 2 -> 6 -> 5
		output: 3 -> 4 -> 7 -> 8 -> 9 -> 1 -> 4 -> 2 -> 6 -> 5
			3 = | 4 - 7 |
			8 = | 9 - 1 |
			4 = | 2 - 6 |

7. Singly linked list of double stores coefficients of a polynomial f(a) from power 0 (first element) to n (last element).
	f(a) = -2a$3 + 5a - 3
		* f(a) = -2a$3 + 0a$2 + 5a$1 + -3a$0
	Then linked list will be: -3 -> 5 -> 0 -> -2
   Write a program to input coefficients from the user and build the linked list. Then input the value of variable "a" and solve the polynomial for the result.
	* user given a = 2;
		* f(2) = -2*2$3 + 0*2$2 + 5*2$1 + -3*2$0 = ??

8. Use java.util.Stack to solve an expression using prefix/postfix conversion. Assume that input expression contains operands and operators separated by spaces. Expression can have operators like (, ), *, /, +, - and $ (power). Note that operand value may range from -999 to +999.
	* 12 + 48 / ( 32 - 28) * -4 + 2 $ 5
		* String[] tokens = str.split(" ");
		* isNumber(String num) --> Integer.parseInt(num) -- if Exception, not a number; else it is number (operand) 

9. Use java.util.Queue to simulate FCFS scheduling algorithm. The jobs information like process id, arrival time and burst time a should be loaded from a text file (example given below). Output should be table printing process id, arrival time, burst time, waiting time and turnaround time in order of scheduling.
   Input format (process id, arrival time and burst time):
	1,0,14
	2,2,6
	3,3,10
	4,6,2
	5,40,10
   * For FCFS algorithm
		* Waiting time = Scheduling time - Arrival time
		* Turn-around time = Completion time - Arrival time

10. Load all movies data from movies_caret.csv into a user-defined hash table. Maximum number of slots in hash table are 100. Use chaining in case of collision. The key is movieId and value is Movie objects.

11. Load employee objects data into java.util.HashMap so that key is empno and value is Emp objects. Arrange all employee objects in a user-defined multiway tree in hierarchial order i.e. each Emp node will have multiple child nodes representing his subordinates. Traverse the tree in BFS order.
	```Java
	HashMap<Integer, Employee> map = new HashMap<>();
	````

	```Java
	class EmpTree {
		static class Node {
			private Employee data;
			private List<Node> children;
			// ...
			public Node(Employee val) {
				data = val;
				children = new ArrayList<Node>();
			}
		}

		private Node root;
		public Node bfs(int empNo) {
			// ...
			return trav;
		}
		public void add(Employee e) {
			Node mgr = bfs(e.getMgr());
			if(mgr != null) {
				Node newNode = new Node(e);
				mgr.children.add(newNode);
			}
		}
	}
	```
12. Create adjacency matrix for the given graph. Implement a function that returns new adjacency matrix after removing the given vertext.
	int[][] removeVertex(int[][] mat, int removeVertexId);

13. Count number of occurrences of each word in the text file.
	* input file:
		* red green blue
		* red red green
		* blue red green
	* Hint:
		* HashMap<String,Integer>: key = word, value = count.
	* output:
		* red = 4
		* green = 3
		* blue = 2

