package ua.lyubchenko.commands.entityCommands;

import ua.lyubchenko.commands.Commands;
import ua.lyubchenko.domains.Customer;
import ua.lyubchenko.repositories.entityRepositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerCommand extends Commands {
    private final String WORD1 = "Если вы выберите ";
    private final String WORD2 = " - вам нужно ввести через пробел ";
    private final String WORD3 = "Например: ";
    private final Customer customer = new Customer();
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final List<String> commands = List.of("\"create\", \"read\", \"update\", \"delete\", \"get\"");

    @Override
    public Integer getMaxId() {
        return customerRepository.getMaxId();

    }
    @Override
    public void update(String param) {
        String[] words = param.split(" ");
        customer.setName(words[0]);
        customer.setLocation(words[1]);
        customer.setId(Integer.parseInt(words[2]));
        customerRepository.update(customer);
    }

    @Override
    public void create(String param) {
        String[] words = param.split(" ");
        customer.setId(Integer.parseInt(words[0]));
        customer.setName(words[1]);
        customer.setLocation(words[2]);
        customerRepository.create(customer);
    }

    @Override
    public void delete(String param) {
        String[] words = param.split(" ");
        customerRepository.delete(Integer.parseInt(words[0]));
    }

    @Override
    public void printInstruction() {
        System.out.println("^--------- CUSTOMERS MENU ---------^");
        System.out.println("COMMAND: " + commands);
        System.out.println("ИНСТРУКЦИЯ ПО ВЫБОРУ КОМАНД:\n" + WORD1 + "\"create\"" + WORD2 + "(id name location). " +
                "" + WORD3 + "create 10 BBC California\nЕсли вы выберите \"read\" - ничего вводить не нужно, выводится список заказчиков хранящихся в БД.\n" +
                "" + WORD1 + "\"update\"" + WORD2 + "(name location id). " +
                "" + WORD3 + "update BBC California 10\n" + WORD1 + "\"delete\" - вам нужно вести (id). " +
                "" + WORD3 + "delete 10\n" + WORD1 + "\"get\" - вам нужно ввести (id). " +
                "" + WORD3 + "get 10\nМаксимальный id \"CUSTOMERS\" - " +getMaxId());
    }

    @Override
    public void read() {
        List<Customer> read = customerRepository.read();
        read.forEach(System.out::println);
    }
}
