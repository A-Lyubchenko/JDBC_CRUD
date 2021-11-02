package ua.lyubchenko.commands;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ICommands {
    Pattern pattern = Pattern.compile("^\\w+");

    void handle(String param, Consumer<ICommands> iCommandsConsumer);

    void printInstruction();

    default Optional<String> getFirstWorld(String param) {
        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            String group = matcher.group();
            return Optional.of(group);
        } else {
            return Optional.empty();
        }
    }

}
