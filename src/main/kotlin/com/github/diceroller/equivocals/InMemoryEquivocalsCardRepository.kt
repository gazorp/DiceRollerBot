package com.github.diceroller.equivocals

class InMemoryEquivocalsCardRepository : EquivocalsCardRepository {

    override fun getRandom(type: TaskType): Card? {
        val card = data.filter { it.type == type }.shuffled().firstOrNull()

        return card?.copy(task = decypher(card.task).replaceFirstChar { it.uppercaseChar() })
    }

    private fun cypher(text: String): String {
        return text.mapIndexed { i, char ->
            val keyChar = CYPHER_KEY[i % (CYPHER_KEY.length - 1)]

            when (val mappedChar = abcMap[char.lowercaseChar()]) {
                null -> char
                else -> abc[(mappedChar + abcMap[keyChar]!!) % abcMap.size]
            }
        }.joinToString("")
    }

    private fun decypher(text: String): String {
        return text.mapIndexed { i, char ->
            val keyChar = CYPHER_KEY[i % (CYPHER_KEY.length - 1)]

            when (val alpha = abcMap[char]) {
                null -> char
                else -> abc[(alpha - abcMap[keyChar]!! + abcMap.size) % abcMap.size]
            }
        }.joinToString("")
    }

    companion object {
        private const val CYPHER_KEY = "экивоки"
        private val abc = "абвгдежзийклмнопрстуфхцчшщъыьэюя"
        private val abcMap = abc.mapIndexed { i, c -> c to i }.toMap()

        private val backwardsDesc = "Наоборот"
        private val wordsDesc = "Объясни словами"
        private val drawingDesc = "Нарисуй"
        private val crocodileDesc = "Покажи жестами"
        private val yesNoDesc = "Да/Нет"

        private val eqDrawBlind = "Нарисуй с закрытыми глазами"
        private val eqThing = "Тварь/Штука"
        private val eqRetarded = "Объясни как умственно отсталый"
        private val eqBrands = "Объясни бренды"
        private val eqHumming = "Напой песню без слов"
        private val eqGames = "Объясни игры"
        private val eqSoundsOnly = "Объясни звуками"
        private val eqBands = "Спой песни исполителей"

        private val data: List<Card> = listOf(
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "юпхзефэ-щрпкффи"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "дкрймцеьдун"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "ецчрюьлсиоугвчрз"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "йпфрщшатз"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "акпкпкакхжьм"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "оьрчььяшшзытв"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "пъипяннпщуцълмифк"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "ъфщсухититъэо"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "окфрцслхзшцй"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "апсоъкоьнт"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "аърптпякуют"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "йшуртшгпхэ"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "пкшвыьечц"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "яышвашоьд"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "зкшвыьефынй"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "оэчзю йкшкь юъцу"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "ошюкьчефи"),
            Card(CardTheme.ChertiYellow, TaskType.BACKWARDS, backwardsDesc, "ошуювпбррр"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "ь йзюпашкрч ляшвычеф"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "еьим, мъцъб"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "рбнпцф битьовй по роинучзп"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "въндоч - уашитюв ълыщкчызшлр кжьр"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "пктку йещнц зъгуцчшп сьвит"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "пе нббхп, епй щвгкн"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "яшуряе ыъэыэп к фтикэ"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "IFUNNY"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "йкшнуслчщмцу линуь"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "йшопь ткфушэы чтьыщлы"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "яе хрхвбнпй"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "яыно нройвч"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "зктку иимк чэ кзюлиимз"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "дчизжж бър, мшмтбнэ"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "цкщ ркх ъзщпсшх цс штпо мшузатп"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "ъщцмятбчиб ыйшув"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "хэф щпктхушшаш сюшощнмак"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "OH WELL"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "кэ соъвчд, чр р еьл?"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "пктвн йкузыжзкз, к ыърщжзш жюйкт"),
            Card(CardTheme.ChertiYellow, TaskType.WORDS, wordsDesc, "лч сщшбшхрятп щмболэфкуц"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "дмымц бкяк"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "йпсмя опту"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "еншваж чи бфрхнну"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "пкф епнжкк"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "опшзск ыйтцх лшррт ыгпб"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "нкт эълыъвае"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "зшугоылюь"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "йкъзбв"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "ншх бтдхр"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "оьыжяшяпъ"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "аърцвткоцт"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "йшпеьллухб"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "зхыг щлхмпцф"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "юппжьцкес"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "мткр ы ьцооьлц"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "фпъэюп читцыри"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "зшфскиппшпйу ннпцу"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "лщитйве"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "гпхуштж швхнлмцт"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "ппътоощ щоуъпт"),
            Card(CardTheme.ChertiYellow, TaskType.DRAWING, drawingDesc, "зъиуыкь амьхэ"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "р фзый ъим щншщфоьш"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "эфын нлхыгой ктхщк"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "ппъмо ипъ 27"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "лнытде бнтют"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "ь ъзпй эщнйвэх"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "рлнтцьв щрпкзэ, н йпмкатнэж"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "яын юпхпхр, йкфв, ь лзч"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "юкймц бпшхаыь пв ыэяит"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "эннпа 7:00"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "вррмб мшхбачл"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "иштр ълфц"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "оп нн ят: яьнкмвч е фзюскт"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "йкузыпффц этяк"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "отщфуцэ мвбчлм"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "ашч-яьлщ"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "ачрнк мш уштбфн"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "дкттйьэй сцаук"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "офииц мкшрщж шъ ркж-ьвн"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "мпшжухзк пцфеьг"),
            Card(CardTheme.ChertiYellow, TaskType.CROCODILE, crocodileDesc, "йшуртшж язщшяпт, лшыътуп"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "бкяв"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "опкзючлп щуъпкхррш"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "ипхкыызтс эълычзшь"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "зкпвыж"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "акштц мшъфуъ"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "змрй"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "мшеф"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "ZOOM"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "тшлдоъпы"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "якфсцъ"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "эуьры"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "ютуюнъб"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "хканйф"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "йпф"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "мткр"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "юэтза"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "хкфсочофцз"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "эчлнцй"),
            Card(CardTheme.ChertiYellow, TaskType.YES_NO_PUZZLE, yesNoDesc, "йкуцьу"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqDrawBlind, "мткрхкяъ"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqRetarded, "оьысьъ ццйсшятхэ"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqBrands, "ншщеюкй\nжноь квый\nрдочлмщмцу ьшкшшпко"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqHumming, "пър юпзт\nрыв йхтпп эрюшхш\nшэзхи шшиоыпо"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqThing, "пктрщпко"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqGames, "GUITAR HERO\nTHE LAST OF US\nмводооф"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqSoundsOnly, "мткр"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqBands, "мшшпьюехдой\nыътйфэхц\nSYSTEM OF A DOWN"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Покажи фильмы", "дкузеж чи тчл к пъынлз\nсшърбмвхрщучеп\nпъэь"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Объясни фильмы", "офкрхж ыхзс\nнийщкжь\nюзж"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Наоборот и значение", "ктлкщтоь"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Наоборот и значение", "бтэрашйтз"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, crocodileDesc, "о йхгьш-йвюктьг"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, wordsDesc, "рзщ очбпшуьч\nъвюккьрпь\nьитшшяыткч"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Нарисуй с закрытыми глазами", "юштвщ ккщфц"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, "Покажи фильмы", "оьшкэьеснтжк\nцнтллу\nщшюыъзю"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, backwardsDesc, "ашкбфтж ъирреф"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqBrands, "зти\nмлхддь\nцрфяэютщк"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, eqBrands, "ахцгбы\nчзюпзънуашз\nещшюку ятпт"),
            Card(CardTheme.ChertiYellow, TaskType.EQUIVOCALS, wordsDesc, "юктвюое\nоохщлцть\nцитаткт"),


            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "ъчъзюшонннк"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "йшпеьвпэшо"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "оьцъо-ашкпьсэо"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "бпфратякърюе"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "ецижфтккшкбц"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "сшърсъэюртьмэьд"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "мкшуухпкхе"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "пшузюккьхряьщ"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "яшуюэпньрпспн"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "жштоьфз"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "бкфгщолъ"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "апхжуъкш-пуупъинкчшу"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "бъимьчлъцитпкчгл"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "рщцтььлыъю"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "пкфвсшфт"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "петдо-аърнк"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "зшуршшижякш"),
            Card(CardTheme.ChertiPink, TaskType.BACKWARDS, backwardsDesc, "ахруаэот"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "ь цчюккйж ппнпл"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "йефто , хз свмил"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "охыщоукес штюпшсочз"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "гтк, авх, ьъвх"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "опфю щььхкд яш нпэ"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "яын ркхт дьхлыг - ъьц эввчршо"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "акфвцхрбиазкь укеткфи яьнкыуо"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "бк фкюр"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "юпп тмря жрпккмшоьщ"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "кэ фьнбк гбор озщкпж б"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "йтххаэ оцгомех йо нкпеьмлъг"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "сьцт ыэцгл рэорпо"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "кп йумэу, р ахий оэц"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "цкщ р ахий оэц"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "яе щаш, хз лшхр р йтххяткытз?"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "фпшфочлмюэ м сжйцчл"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "зшувълей сцффпшй чв чтуооьидщйвь"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "бми р юпщмьчвбхряье"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "ъхнеочпчгл юэыцп"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "зктку еонк й щшктэйеквм"),
            Card(CardTheme.ChertiPink, TaskType.WORDS, wordsDesc, "ашмйцхик сьобпшицмэпъ шткн-мьчак"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "йтщфуъ ыцуцызк"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "ййщр пашшв"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "мърпуые епапншщеухщ"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "ашурршишфмо я лрщшяп"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "зкт шкзкъю"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "зэтно зшужбчэ"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "D&D"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "бкшзъ"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "япсс"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "мъцеюкйцруа"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "охрйуъеч"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "оьрмуъмкт"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "бихв"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "вррмб мшхбачл"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "мкумоч"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "оьрмуъмкт р ппузсъэцн"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "оьц"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "ошйветж крюы"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "ь тратз, фй зшъкш"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "пшхпо пшхвщжкттв"),
            Card(CardTheme.ChertiPink, TaskType.DRAWING, drawingDesc, "пээнц"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "йпфрщшатз"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "опкзючлп щуъпкхррш"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "эуъкжчеф по йтунцшк"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "зшшрщпяк жюкй"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "нтявюо ыисьнлм"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "яшуряе чн ящеаг, никпв чв шзячеаг"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "ь йюм гпхыцч т жуьву"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "пкф эълмнтнип"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "мшсжб мъцдуъы"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "мкътцкня мцъеху"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "акшнуц внлш"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "еншррев идашйкъэ"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "бэй яьлтъ рпзшкрч"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "р фзый пщфк пшщф"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "йкс гкйщщ"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "апсопшж чтььем PSP"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "йкуюетзт иоъьь ъовиет"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "зьц пэбпъ ъепж сьыроы?"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "юэурефэ щ ъкзшф"),
            Card(CardTheme.ChertiPink, TaskType.CROCODILE, crocodileDesc, "мпшзюея хв щлфытцьщ"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "ншузрфэ"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "отфзвълщцнкызтс пэижквю"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "мпхйо"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "рфынухв"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "брцвы ншынцча"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "зкуюнч"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "ъхдц"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "TELEGRAM"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "ншожуыпмц"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "скъв"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "мхипжпп"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "юшынцча"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "въндоч"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "бъиоо"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "мхнляьвуап"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "зшуюдш"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "хфцно"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "зшшец"),
            Card(CardTheme.ChertiPink, TaskType.YES_NO_PUZZLE, yesNoDesc, "апшоцшкк"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqThing, "ошщкяфэ к шшижюр"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqRetarded, "нкщущшвчрз цлсозефэ"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqBrands, "юпурюэоытвн зшщоуьефи\nчэщрфшт тп епнчцеьхлмтк\nзшшррфэ рй флънпьмзт"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqHumming, "пър эшишщмц\nй хуор окаж м ньчбшх\nхыле - зшхю"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqThing, "зээпн кк тоулчн"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqDrawBlind, "юкхвышяес гхвл"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqSoundsOnly, "зшьз"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqThing, "йкькн"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, wordsDesc, "зкт реюъифкыь рй юикхв"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Наоборот и значение", "эчцоцй"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Наоборот и значение", "отйвютп"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqThing, "ъфрдьфе"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Покажи с закрытыми глазами", "дклвтфэ мэюе"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Объясни фильмы", "кжж-чшнф, ыжы-срюф\nьточуэпуштж кзяьеф\nэшвсм р мэщвы"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, backwardsDesc, "съруакжхц юкзкфвшксш"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Покажи жестами", "кшкэч пмцл щнтзфухщ"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Спой песню", "LUMEN\nRAMMSTEIN\nзшшрщж т ъбь\n"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, "Спой песню", "якузютж фзщкбсн\nPLACEBO\nBLACK EYED PEAS"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, drawingDesc, "эмнпаэнк\nшшикфгбы"),
            Card(CardTheme.ChertiPink, TaskType.EQUIVOCALS, eqBrands, "мткр ы силдпй\nсощэ фрфпп"),


            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "пънсуьэьд"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "нэтрэшгкъку"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "мжзпьцр фрюп щц шшипхр"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "оьшвг е хзыкятщфк я увя-яплвяп"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "пшщмо"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "мъррпшбърфкыь"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "эчъкэпнычкюккь"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "зтчбашз"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "ячнйощкш"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "гкмкык"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "офшзэй ынттав"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "зхихяьншьрпть"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "йэшвжфе"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "дктватпж ушккоин"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "ипхю"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "кпкэышотфвн иплмьыпж гйьей"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "зшхуучоэщ"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "ахийо нкпгурэхрук"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "мшмнцсшмифкыь"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "зшфсщтйпхф"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "дкккяьктт"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "бктфцхлытрэ"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "ес ршчэ мхщш"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "пъцеоьвхдпйу"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "яшхю"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "ятшфбкижхэч ншфвы"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "опшждпвотв"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "ль дьъль сьмлъцф"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "юкйрефе к фтяшъз"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "лщгф"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "ь ефц ашшэ м ьннумесцту ятмвщ"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "окмръкдшэкяь"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "тшъю никп резшук"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "кпчтцхебхэч гпщф"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "гкуряьщ"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "бпкхжфэ, оьркш у мэцр эшдчимьцеьдун?"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ошйносктъзщжктюв"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "хмнжяфэй ууцщй"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "нппваж щшврор-фвафр"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "цптрафэ"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "ъьц эълыър щнкпжытз твшшж-ър!"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "нпчхакутз"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "рц йо нкпхъ дкэрттп"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "гпфвычеаи"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "ечъхцаей"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "мъцоьбеьд ышат"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "яшпнмлипхпой"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "йкътоыктяваж"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "ккцыбщщ"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "рыъвщшоьд"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "беаваж чи щкбкх"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ппфсуъэцнпа"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "зшфрш я лрюхв"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "омржочеп дяхвщыа"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "мырчьхлн"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "кпокажой"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "йпувыялхрм"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "эощмцп цымц"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "мшуаптхж к флсув"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "яшщфьъа"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "бпъзшьлъ нфт"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ткшвшьвъруатзк"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "онцтоьщ цф ыпемв"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "фкс эктчнф мвчрмьц"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "отхбш"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "кпшдцвзт ъохьь"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ечъзщхвфъхох"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "зкт хк фиоучкшс яьвчцл"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "нкщфойпж ра рцрнучей"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "эчъкэкптз"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "япътучеаи"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "яоцчышяпхку"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "бпшиоьщ ычь яшщфюш"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "юэшб зйшюкч"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "мърдйбзк"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "бповри"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "окфрюпэхрйоаей"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "яшуряе оггьц"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "мъцъъеачыфк"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "ттътьыпж"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "зэчкажой"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "юпщсуъощнматячзм"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "я узяэ ъийткякуун пшчрю бъцдьывфи"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "мънуъезкъюяй"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "офкрхчьф"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "фэкуамэ кзюэыгрч"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "бшщфьткыъдь"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "мшмущэхткваж"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "яшмкаж си ышо"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "дэм"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "зэуюаэнчгл влф"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "нкпдюкпчрм"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "бэав эххи р мйъмц"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "обрфоьщ крюшк"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "тшузютз"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "хтшрштж озяь"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ещцчьчбърм"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "йшшрх мш мьрв"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "окямьмэьд"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "зърм"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "кп гбое укгш, чршк шхр ьеяц"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ъщрнущпшрж"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "офысой цыияфэй ущпдк"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "кпязъ зъгфк"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "оьшвяьщ"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "еычэакктн яхэмцл"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "окфрьлйкх"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "мъцдуъзк по яврдьыпж"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "хпкзщтпж хжкйт"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "апхкч"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "лщнъцьщ"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "опхуьъефи"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "мъцлат шлрыж т дьор"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "кпфвн оанпо"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "еыъзютзк"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "фэкуамл уршьь"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "йэозыпккккяьктюв"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "кп уйщщ фпу ошую чэ швыэ"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "лыърюшгчц, шзъиъучл!"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "рордщпктн"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "япшкаж чи яхлмц"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "ашурршзъыиучеп"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "яьцтьп огчочеп"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "рщиуаж м ещкдкэ"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "зкчтцс"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "оцшвт"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "нкпрекншквытв"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "бэъю чэ фрщшзш"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "зшамц офшзпэп хв орвн"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "рщшбъыпмц"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "иийрркпжщб"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "отфхщйкьтв"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "лохрч ипкрч"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "пэлртэй"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "ъыъза"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "ипйзхтпж"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "оптуьщэьцньн"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "ллхбаж т сщкзкъю"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "мпявщжзк"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "иктръфэ"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "бкъю хвги"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "зтхзяьвьрмо"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "бпшиоьщыз хк ыцньцечтх"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "йшъваж чи бы"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "кклньыпж"),
            Card(CardTheme.Sensations, TaskType.BACKWARDS, backwardsDesc, "офшръчлыъю"),
            Card(CardTheme.Sensations, TaskType.WORDS, wordsDesc, "охижьыпъиуачеф"),
            Card(CardTheme.Sensations, TaskType.DRAWING, drawingDesc, "мърпмяэьдун"),
            Card(CardTheme.Sensations, TaskType.CROCODILE, crocodileDesc, "яетвпхрбрдоьщыз"),
            Card(CardTheme.Sensations, TaskType.YES_NO_PUZZLE, yesNoDesc, "лщиуышоьд"),
        )
    }
}