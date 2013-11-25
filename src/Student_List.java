import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class Student_List extends ArrayList<Student> {
			
	public Boolean removeStudent(int ID) {
  		ListIterator<Student> iter = this.listIterator();
  		Boolean found = false;
  		while(iter.hasNext()){
  		    if(iter.next().getID() == ID){
  		        iter.remove();
  		        found = true;
  		    }
  		}  		
  		return found;
	}

	public Boolean removeStudent(Student student) {
  		ListIterator<Student> iter = this.listIterator();
  		Boolean found = false;
  		while(iter.hasNext()){
  		    if(iter.next().getID() == student.getID()){
  		        iter.remove();
  		        found = true;
  		    }
  		}  		
  		return found;
	}
}
