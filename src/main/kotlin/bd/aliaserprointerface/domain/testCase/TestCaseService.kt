package bd.aliaserprointerface.domain.testCase

import org.springframework.stereotype.Service

@Service
class TestCaseService(val testCaseRepository: TestCaseRepository) {
    fun addTestCase(testCase: TestCase) = testCaseRepository.save(testCase)

    fun addTestCases(testCases: List<TestCase>): List<TestCase> = testCaseRepository.saveAll(testCases)

    fun getFirstReadyTestCase() = testCaseRepository.getFirstReadyTestCase()

    fun updateTestCase(testCase: TestCase) = testCaseRepository.save(testCase)
}