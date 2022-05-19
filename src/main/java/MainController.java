import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MainController implements NativeKeyListener{
    public static final Path file= Paths.get("Keys.txt");
    MainController() {
        try {
            addListener();
        }catch (Exception e){

        }

    }
    private void addListener() throws NativeHookException {
        // Activate the library
        GlobalScreen.registerNativeHook();
        //Add Listener to the board
        GlobalScreen.addNativeKeyListener(new KeyListener());
    }
}
