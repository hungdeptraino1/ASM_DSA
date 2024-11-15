public class StudentList {
    Student[] list = new Student[0];
    private int index = -1;

    void reSize(){
        if(list.length == 0){
            list = new  Student[1];

        }else {
            Student[] tempList = new Student[list.length * 2];
            System.arraycopy(list, 0, tempList,0, list.length);
            list = tempList;
        }
    }


    void printList(){
        for (int i = 0; i < size(); i++) {
            Student s = list[i];
            if (s != null) {
                System.out.println((i + 1) + ": " + s.printStudent());
            }
        }
    }


    void add(Student student){
        if(index + 1 == list.length){
            reSize();
        }
        index ++;
        list[index] = student;
    }

    void delete(int i){
        if(i < 0 || i > index){
            System.out.println("Invalid index: " + i);
            return;
        }
        for (int j = i; j < index; j++){
            list[j] = list[j + 1];

        }
        list[index] = null;
        index--;
    }


    int size(){
        return index + 1;
    }


    boolean contain (Student student){
        for(Student s : list){
            if (student.getStudentid().equals(s.getStudentid())){
                return true;
            }
        }
        return false;
    }



    void edit(String id, String newId, String newName, double newMarks) {
        for (int i = 0; i <= index; i++) {

            if (list[i] != null && list[i].getStudentid().equals(id)) {
                list[i].setStudentid(newId);
                list[i].setName(newName);
                list[i].setMarks(newMarks);
                list[i].getRank();
                break;
            }
        }
    }
}
