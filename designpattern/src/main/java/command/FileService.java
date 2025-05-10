package command;

public class FileService {
  String filename;

  void open(){
    filename = "test.txt";
    System.out.println(filename + " open");
  }

  void print(){
    System.out.println(filename + " print");
  }
}
