package ch04_Inheritance.advanced.ch07.exam;

public class FileDownloadServlet extends HttpServlet {
    @Override
    public void service() {
        System.out.println("파일 다운로드 합니다.");
    }
}