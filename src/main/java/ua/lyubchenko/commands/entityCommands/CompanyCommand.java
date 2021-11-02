package ua.lyubchenko.commands.entityCommands;

import ua.lyubchenko.commands.Commands;
import ua.lyubchenko.domains.Company;
import ua.lyubchenko.repositories.entityRepositories.CompanyRepository;

import java.util.List;

public class CompanyCommand extends Commands {
    private final String WORD1 = "Если вы выберите ";
    private final String WORD2 = " - вам нужно ввести через пробел ";
    private final String WORD3 = "Например: ";
    private final Company company = new Company();
    private final CompanyRepository companyRepository = new CompanyRepository();
    private final List<String> commands = List.of("\"create\", \"read\", \"update\", \"delete\", \"get\"");

    @Override
    public void create(String param) {
        String[] words = param.split(" ");
        company.setId(Integer.parseInt(words[0]));
        company.setName(words[1]);
        company.setLocation(words[2]);
        companyRepository.create(company);

    }

    @Override
    public void read() {
        List<Company> read = companyRepository.read();
        read.forEach(System.out::println);

    }

    @Override
    public void update(String param) {
        String[] words = param.split(" ");
        company.setName(words[0]);
        company.setLocation(words[1]);
        company.setId(Integer.parseInt(words[2]));
        companyRepository.update(company);

    }

    @Override
    public void delete(String param) {
        String[] words = param.split(" ");
        companyRepository.delete(Integer.parseInt(words[0]));
    }

    @Override
    public void printInstruction() {
        System.out.println("^--------- COMPANIES MENU ---------^");
        System.out.println("COMMAND: " + commands);
        System.out.println("ИНСТРУКЦИЯ ПО ВЫБОРУ КОМАНД:\n" + WORD1 + "\"create\"" + WORD2 + "(id name location). " +
                "" + WORD3 + "create 10 BBC California\nЕсли вы выберите \"read\" - ничего вводить не нужно, выводится список компаний хранящихся в БД.\n" +
                "" + WORD1 + "\"update\"" + WORD2 + "(name location id). " +
                "" + WORD3 + "update BBC California 10\n" + WORD1 + "\"delete\" - вам нужно вести (id). " +
                "" + WORD3 + "delete 10\n" + WORD1 + "\"get\" - вам нужно ввести (id). " +
                "" + WORD3 + "get 10");
    }
}
