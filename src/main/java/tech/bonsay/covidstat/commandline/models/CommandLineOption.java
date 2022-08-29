package tech.bonsay.covidstat.commandline.models;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandLineOption extends OptionsBase {
    @Option(
            name = "help",
            abbrev = 'h',
            help = "Prints usage info.",
            defaultValue = "false"
    )
    public boolean help;

    @Option(
            name = "country",
            abbrev = 'c',
            help = "Any country name (case sensitive) Example: France",
            category = "startup",
            defaultValue = ""
    )
    public String country;

    @Option(
            name = "ab",
            abbrev = 'a',
            help = "Any country ISO abbreviation (example: FR) (takes precedence over \"country\" parameter), Example: FR",
            category = "startup",
            defaultValue = ""
    )
    public String ab;
}
