import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(
    packages = ["example"],
    importOptions = [ImportOption.DoNotIncludeTests::class],
)
class ArchitectureTests {

    @ArchTest
    fun `Check service application starters`(classes: JavaClasses) {
        print(classes)
        ArchRuleDefinition.classes()
            .that().areAnnotatedWith("org.springframework.boot.autoconfigure.SpringBootApplication")
            .should().haveSimpleNameEndingWith("Starter")
            .check(classes)
    }
}
