package contracts.age.rest

org.springframework.cloud.contract.spec.Contract.make {
	request {
		description("""
Represents a successful scenario of a person that has an odd age

given:
	client has an odd age
when:
	he applies
then:
	we'll grant
""")
		method 'POST'
		url '/even'
		body(
				age: value(consumer(regex('[0-9][13579]')))
		)
		headers {
			header 'Content-Type', 'application/json'
		}
	}
	response {
		status 200
		body( """
			{
                "status": "NOT_OK"
			}
			""")
		headers {
			header(
					'Content-Type', value(consumer('application/json'),producer(regex('application/json.*')))
			)
		}
	}
}
