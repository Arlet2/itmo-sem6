rootProject.name = "tpo1"
include("src:main:sin")
findProject(":src:main:sin")?.name = "sin"
include("src:sin")
findProject(":src:sin")?.name = "sin"
include("src:merge-sort")
findProject(":src:merge-sort")?.name = "merge-sort"
include("src:story")
findProject(":src:story")?.name = "story"
