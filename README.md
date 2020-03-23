# PortfolioAdvisor
REST Portfolio Advisor project
 
This project outlines a two part scenario wherein a customer gets a recommendation for an ideal portfolio, and then understands the steps needed to balance their current portfolio to match this ideal one.  
 
Imagine you are building a software that mimics the service of one financial advisor who can at most handle 2 unique clients at the same time.  The financial advisor provides the following services. 
 
Part 1: Recommend an ideal portfolio A financial advisor normally asks a few questions to a new customer so as to understand their risk profile, and derives a ‘risk tolerance score’ (or risk preference) for the customer. For the purposes of this project, we will curtail the scope of this flow by having the client directly provide the advisor with a risk preference. 
 ● Input 1: ​A client provides the advisor his/her risk preference (1 being very risk averse, and 10 being insensitive to risk). 
 
The financial advisor has a few pre-defined portfolios which allocates a client’s money in certain proportions across multiple investment categories to balance risk. 
 
Recommend a portfolio based on input. The recommended portfolio will be based on a chart with 10 rows (representing possible risk levels) and 5 columns (representing investment categories). The cells will be populated with percent allocation based on a combination of risk and investment categories. Every row should add up to 100%. You can make up your own categories (i.e. bond, small cap, large cap, etc.).  Reference http://financial-advisor-beta.surge.sh​. 
 ● Output 1: ​Return to the client the recommended portfolio based on his/her risk preference 
 
 Part 2 Recommend changes to a user’s actual portfolio 
 ● Input 2:​ user tells the advisor for how much money they currently have allocated to each of the 5 investment categories. This is requested in $ (not a %) 
 ● Output 2: ​If the user's current allocation is not ideal for their risk level as displayed in part 1 above, recommend an allocation transference to correspond with suggested allocation. 
 
The math should add up such that if the user executes the transactions as recommended in output 2, his portfolio provided in Input 2 matches in % to the recommended portfolio in Output 1. Assume that there is a cost to the user (not factored in the calculations) for each transactions and hence the number of transactions recommended should be minimum possible to match the ideal portfolio. 
 
Coding Requirements 
● Build a production-quality Java REST server that provides the above services.  Define appropriate REST APIs and data structures to satisfy the need for these services. 
● Make assumptions as necessary and write down these assumptions. 
● Write API test cases to show that the system is working. 
● Be mindful of error handling 

