package tugas3belumrefactor;

import java.util.ArrayList;

public class Dialog implements DialogAction {
    private ArrayList<String> dialogs = new ArrayList<>();


    @Override
    public void ShowDialogue(int currentDialogueIndex){
        System.out.println(getDialogs().get(currentDialogueIndex));
    }
    @Override
    public void AddDialogue(String dialogNew){
        getDialogs().add(dialogNew);
    }

    public ArrayList<String> getDialogs() {
        return dialogs;
    }
}
