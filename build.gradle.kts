plugins {
	id("earth.terrarium.cloche") version "0.17.7"
}

repositories {
	cloche.librariesMinecraft()

	mavenCentral()

	cloche {
		main()

		mavenFabric()
		mavenNeoforgedMeta()
		mavenNeoforged()

		mavenParchment()
	}
}

cloche {
	minecraftVersion = "1.21.1"

	metadata {
		modId = "perch"
		name = "Perch"
		license = "GPL-3.0"
		description = "Keep parrots on your shoulder!"
		icon = "assets/perch/icon.png"

		author("jolkert")
	}

	mappings {
		official()
		parchment("2024.11.17")
	}

	neoforge {
		loaderVersion = "21.1.135"

		metadata {
			mixins.from("src/common/perch.mixins.json")
		}

		data()

		runs {
			server()
			client()
			data()
		}
	}

	fabric {
		loaderVersion = "0.16.10"

		metadata {
			entrypoint("main", "dev.jolkert.perch.fabric.PerchFabric")
			mixins.from("src/common/perch.mixins.json", "src/fabric/perch.fabric.mixins.json")

			dependency("minecraft", minecraftVersion.get())
		}

		data()
		client {
			tasks.named<Jar>(sourceSet.jarTaskName) {
				duplicatesStrategy = DuplicatesStrategy.INCLUDE
			}
		}

		dependencies {
		}

		runs {
			server()
			client()
			data()
		}
	}
}
