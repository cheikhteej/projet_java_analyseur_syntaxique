import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Selecteur {
    private List<String> selecteur;
    private int position;

    public Selecteur(String exp) {
        selecteur = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|[+\\-*/()]|\\S");
        Matcher matcher = pattern.matcher(exp);
        while (matcher.find()) {
            selecteur.add(matcher.group());
        }
        position = 0;
    }

    public boolean hasNext() {
        return position < selecteur.size();
    }

    public String next() {
        return selecteur.get(position++);
    }

    public String select() {
        return selecteur.get(position);
    }
}