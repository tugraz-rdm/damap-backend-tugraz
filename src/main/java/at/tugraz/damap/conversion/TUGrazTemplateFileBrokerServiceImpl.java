package at.tugraz.damap.conversion;

import javax.enterprise.context.ApplicationScoped;

import at.ac.tuwien.damap.conversion.TemplateFileBrokerServiceImpl;
import io.quarkus.arc.Priority;
import lombok.extern.jbosslog.JBossLog;

@ApplicationScoped
@Priority(1)
@JBossLog
public class TUGrazTemplateFileBrokerServiceImpl extends TemplateFileBrokerServiceImpl {
    // We do not override templates right now. Core templates have been adapted to
    // be general and not include university specifics.

    // In case templates have to be adapted, place template and resource files in
    // the `resources/at/tugraz/damap/template` folder. Then override the
    // appropriate methods here.
}
