import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication

@AnalyzeClasses(
    packages = ["BOOT-INF.classes.example"],
    importOptions = [ImportOption.DoNotIncludeTests::class],
)
class ArchitectureTests {

    @ArchTest
    fun `Check service application starters`(classes: JavaClasses) {
        print(classes)
        ArchRuleDefinition.classes()
            .that().areAnnotatedWith(SpringBootApplication::class.java)
            .should().haveSimpleNameEndingWith("Starter")
            .check(classes)
    }
}
