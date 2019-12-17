package bd.aliaserprointerface.api.testCase

import bd.aliaserprointerface.domain.testCase.TestCase
import bd.aliaserprointerface.domain.testCase.TestCaseService
import bd.aliaserprointerface.domain.testCase.TestCaseStatus
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class TestCaseController(val testCaseService: TestCaseService) {
    companion object {
        private const val TEST_CASE_BASE_PATH = "/testcase"

        private const val ADD_TEST_CASES_PATH =
            "$TEST_CASE_BASE_PATH/all"
    }

    private val log = LoggerFactory.getLogger(TestCaseController::class.java)

    @PostMapping(TEST_CASE_BASE_PATH)
    fun addTestCase(@RequestBody testCase: TestCase) {
        log.info("HTTP method POST\t$TEST_CASE_BASE_PATH")
        testCaseService.addTestCase(testCase)
    }

    @PostMapping(ADD_TEST_CASES_PATH)
    fun addTestCases(@RequestBody testCases: List<TestCase>) {
        log.info("HTTP method POST\t$ADD_TEST_CASES_PATH")
        log.info("Size: ${testCases.size}")
        testCases.forEach { log.info("${it.id}, ${it.leftId}, ${it.leftAlias}, ${it.leftDescription}, ${it.rightId}, ${it.rightAlias}, ${it.rightDescription}") }
        testCaseService.addTestCases(testCases)
    }

    @GetMapping(TEST_CASE_BASE_PATH)
    fun getFirstReadyTestCase(): TestCase {
        log.info("HTTP method GET\t$TEST_CASE_BASE_PATH")
        val readyTestCase = testCaseService.getFirstReadyTestCase()
        testCaseService.updateTestCase(
            TestCase(
                readyTestCase.id,
                readyTestCase.leftId,
                readyTestCase.leftAlias,
                readyTestCase.leftDescription,
                readyTestCase.rightId,
                readyTestCase.rightAlias,
                readyTestCase.rightDescription,
                TestCaseStatus.IN_PROGRESS.ordinal
            )
        )
        log.info("${readyTestCase.id}, ${readyTestCase.leftId}, ${readyTestCase.leftAlias}, ${readyTestCase.rightId}, ${readyTestCase.rightAlias}, ${readyTestCase.status}")
        return readyTestCase
    }

    @PutMapping(TEST_CASE_BASE_PATH)
    fun updateTestCase(@RequestBody testCase: TestCase) {
        log.info("HTTP method PUT\t$TEST_CASE_BASE_PATH")
        testCaseService.updateTestCase(testCase)
    }
}