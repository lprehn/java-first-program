import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import java.util.Arrays;
import java.util.Map;

public class Finance {
    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR ="mortgageCalculator";

    public final static Map<String, String> commandsToUsage =
            Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
                    SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
                    MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");

    public static void main(String[] args) {
        String command = args[0];

        //check if the first argument (the command) exists
        if (!commandsToUsage.containsKey(command))
        {
            System.out.println(command + ": command not found");
            return;
        }

        boolean isValidCommand = validateCommandArguments(args);

        //check if the command and following arguments are valid
        if (!isValidCommand)
        {
            System.out.println(commandsToUsage.get(args[0]));
            return;
        }

        //if both are true, execute the command
        executeCommand(command, Arrays.copyOfRange(args,1,args.length));
    }

    private static boolean validateCommandArguments(String[] args)
    {
        switch(args[0])
        {
            case BEST_LOAN_RATES:
                if (args.length==1)
                    return true;
            case SAVINGS_CALCULATOR:
                if (args.length==3)
                    return true;
            case MORTGAGE_CALCULATOR:
                if (args.length==4)
                    return true;
        }
        return false;
    }

    private static void executeCommand(String command, String[] arguments)
    {
        switch (command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
        }
    }
}
