package com.revature.utils;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;

import java.util.ArrayList;
import java.util.List;

public class TableOutput {


    public  void printExpenseTable(AsciiTable table, List<ArrayList<Object>> expenses) {
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.addRule();
        table.addRow("exp_id", "emp_username", "expense", "cost", "desc", "date", "status", "category");
        table.addRule();
        for (ArrayList<Object> expense : expenses) {
            table.addRow(expense);

        }
        table.addRule();
        table.getRenderer().setCWC(cwc);
        System.out.println(table.render());
    }

    public void printProcessedTable(AsciiTable table, List<ArrayList<Object>> expenses){
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.addRule();
        table.addRow("expense", "employee", "manager", "status", "comments");
        table.addRule();
        for (ArrayList<Object> expense : expenses) {
            table.addRow(expense);

        }
        table.addRule();
        table.getRenderer().setCWC(cwc);
        System.out.println(table.render());
    }

    public  void printDateReport(AsciiTable table, List<Object> expenses) {
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.addRule();
        table.addRow("expense count", "expense total");
        table.addRule();

        table.addRow(expenses.get(0), expenses.get(1));


        table.addRule();
        table.getRenderer().setCWC(cwc);
        System.out.println(table.render());

    }

    public  void printReport(AsciiTable table, List<Object> expenses){
        CWC_LongestLine cwc = new CWC_LongestLine();
        table.addRule();
        table.addRow(expenses.get(3),"expense count", "expense total");
        table.addRule();

        table.addRow(expenses.get(0), expenses.get(1), expenses.get(2));


        table.addRule();
        table.getRenderer().setCWC(cwc);
        System.out.println(table.render());
    }

}
