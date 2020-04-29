import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot  extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getFrom().getFirstName()+" : "+update.getMessage().getText());
//
//        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
//        sendMessage.setText("Hello "+update.getMessage().getFrom().getFirstName()+"\n"+update.getMessage().getText());
        String command=update.getMessage().getText();

        SendMessage message = new SendMessage();

        if(command.equals("/myname")){

            System.out.println(update.getMessage().getFrom().getFirstName());

            message.setText(update.getMessage().getFrom().getFirstName());
        }

        else if (command.equals("/start")){

            System.out.println("start "+update.getMessage().getFrom().getFirstName());
            message.setText("Hello "+update.getMessage().getFrom().getFirstName()
            +"\n"+"Nice to meet you");
        }

        else if (command.equals("/mylastname")){

            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        else if (command.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }

        else {
            System.out.println(update.getMessage().getFrom().getFirstName()+": "+update.getMessage().getText());
            message.setText(update.getMessage().getText());
        }

        message.setChatId(update.getMessage().getChatId());


        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "ShumaEdu_Bot";
    }

    @Override
    public String getBotToken() {
        return "1202187442:AAHgdhI9w0yGnx-4ao0tJgjJrAigmOH8qyk";
    }
}
