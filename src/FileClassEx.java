import java.io.File;

public class FileClassEx {
    public static void main(String[] args) {
        System.out.println("~~~~~" + dir.getPath() + "의 서브 리스트 입니다.~~~~~");
        File[] subFiles = dir.listFiles();

        for(int i=0; i<subFiles.length; i++) {
            File f = subFiles[i];
            long t = f.lastModified();
            System.out.print(f.getName());
            System.out.print("\t파일 크기: " + f.length());
            System.out.printf("\t수정한 시간: %tb %td %ta %tT \n",t,t,t,t);
        }
    }
    
    
}
