package at.tugraz.damap.conversion;

import javax.enterprise.context.ApplicationScoped;

import at.ac.tuwien.damap.conversion.TemplateFileBrokerServiceImpl;
import io.quarkus.arc.Priority;
import lombok.extern.jbosslog.JBossLog;

@ApplicationScoped
@Priority(1)
@JBossLog
public class TUGrazTemplateFileBrokerServiceImpl extends TemplateFileBrokerServiceImpl {
}
