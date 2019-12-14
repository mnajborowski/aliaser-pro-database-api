package bd.aliaserprointerface.api.testCase

import bd.aliaserprointerface.api.recipe.RecipeController
import bd.aliaserprointerface.domain.testCase.TestCase
import bd.aliaserprointerface.domain.testCase.TestCaseService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class TestCaseController(val testCaseService: TestCaseService) {
    companion object {
        private const val TEST_CASE_BASE_PATH = "/testcase"
    }

    private val log = LoggerFactory.getLogger(TestCaseController::class.java)

    @PostMapping(TEST_CASE_BASE_PATH)
    fun addTestCase(@RequestBody testCase: TestCase): TestCase {
        log.info("HTTP method POST\t$TEST_CASE_BASE_PATH")
        return testCaseService.addTestCase(testCase)
    }

    @GetMapping(TEST_CASE_BASE_PATH)
    fun getFirstReadyTestCase(): TestCase {
        log.info("HTTP method GET\t$TEST_CASE_BASE_PATH")
        return testCaseService.getFirstReadyTestCase()
    }

    @PutMapping(TEST_CASE_BASE_PATH)
    fun updateTestCase(@RequestBody testCase: TestCase): TestCase {
        log.info("HTTP method PUT\t$TEST_CASE_BASE_PATH")
        return testCaseService.updateTestCase(testCase)
    }
}