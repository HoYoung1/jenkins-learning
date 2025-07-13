import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class BatchJob {
    
    public static void main(String[] args) {
        System.out.println("=== Jenkins 배치 작업 시작 ===");
        
        // 현재 시간 기록
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        
        System.out.println("실행 시간: " + timestamp);
        
        // 배치 작업 시뮬레이션
        try {
            // 로그 파일 생성
            String logFileName = "batch_log_" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";
            FileWriter writer = new FileWriter(logFileName);
            
            writer.write("=== 배치 작업 로그 ===\n");
            writer.write("시작 시간: " + timestamp + "\n");
            
            // 작업 시뮬레이션
            for (int i = 1; i <= 5; i++) {
                System.out.println("작업 " + i + " 처리 중...");
                writer.write("작업 " + i + " 완료\n");
                
                // 작업 시간 시뮬레이션
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            writer.write("배치 작업 완료: " + LocalDateTime.now().format(formatter) + "\n");
            writer.close();
            
            System.out.println("로그 파일 생성: " + logFileName);
            System.out.println("=== 배치 작업 완료 ===");
            
        } catch (IOException e) {
            System.err.println("로그 파일 생성 실패: " + e.getMessage());
            System.exit(1);
        }
    }
} 