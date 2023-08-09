//package com.suyo.quran.service.telegram;
//
//import com.suyo.quran.config.TelegramProperties;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Dice;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
//import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
//import org.telegram.telegrambots.meta.api.objects.polls.Poll;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//@Component
//@RequiredArgsConstructor
//public class TelegramConfig extends TelegramLongPollingBot {
//
//    private final TelegramProperties properties;
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        if (update.hasMessage()) {
//            final Message message = update.getMessage();
//            if (message.hasSticker()) {
//                final SendMessage sendMessage = new SendMessage();
//                sendMessage.setText("yaxshi <b>yasxhi</b>");
//                sendMessage.setChatId(message.getChatId().toString());
//                sendMessage.setParseMode("html");
//                sendMessage.setReplyToMessageId(message.getMessageId());
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            } else if (message.hasText()) {
//                System.out.println("hasText");
//            } else if (message.hasDocument()) {
//                System.out.println("hasDocument");
//            } else if (message.hasVideo()) {
//                System.out.println("hasVideo");
//            } else if (message.hasAudio()) {
//                System.out.println("hasAudio");
//            } else if (message.hasVoice()) {
//                System.out.println("hasVoice");
//            } else if (message.hasLocation()) {
//                System.out.println("hasLocation");
//            } else if (message.hasEntities()) {
//                System.err.println("hasEntities");
//            } else if (message.hasPhoto()) {
//                System.out.println("hasPhoto");
//            } else if (message.hasInvoice()) {
//                System.err.println("hasInvoice");
//            } else if (message.hasSuccessfulPayment()) {
//                System.err.println("hasSuccessfulPayment");
//            } else if (message.hasContact()) {
//                System.out.println("hasContact");
//            } else if (message.hasVideoNote()) {
//                System.out.println("hasVideoNote");
//            } else if (message.hasPassportData()) {
//                System.err.println("hasPassportData");
//            } else if (message.hasAnimation()) {
//                System.err.println("hasAnimation");
//            } else if (message.hasPoll()) {
//                System.out.println("hasPoll");
//            } else if (message.hasDice()) {
//                final Dice dice = message.getDice();
////                switch (dice.getEmoji()) {
////                    case "DICE"->,
////                    case "DARTS"->,
////                    case "BASKETBALL"->,
////                    case "FOOTBALL"->,
////                    case "SLOT_MACHINE"->,
////                    <DiceEmoji.BOWLING>
////                }
////                System.out.println(dice.getEmoji());
////                System.out.println(dice.getValue());
//                System.out.println("hasDice");
//            } else if (message.hasViaBot()) {
//                System.out.println("hasViaBot");
//            } else if (message.hasReplyMarkup()) {
//                System.out.println("hasReplyMarkup");
//            }
//        } else if (update.hasInlineQuery()){
//            final InlineQuery inlineQuery = update.getInlineQuery();
//        } else if (update.hasChosenInlineQuery()) {
//            final ChosenInlineQuery chosenInlineQuery = update.getChosenInlineQuery();
//        } else if (update.hasCallbackQuery()) {
//            update.getCallbackQuery();
//        } else if (update.hasEditedMessage()) {
//            update.getEditedMessage();
//        } else if (update.hasChannelPost()) {
//            update.getChannelPost();
//        } else if (update.hasEditedChannelPost()) {
//            update.getEditedChannelPost();
//        } else if (update.hasShippingQuery()) {
//            update.getShippingQuery();
//        } else if (update.hasPreCheckoutQuery()) {
//            update.getPreCheckoutQuery();
//        } else if (update.hasPoll()) {
//            update.getPoll();
//        } else if (update.hasPollAnswer()) {
//            update.getPollAnswer();
//        } else if (update.hasMyChatMember()) {
//            update.getMyChatMember();
//        } else if (update.hasChatMember()) {
//            update.getChatMember();
//        } else if (update.hasChatJoinRequest()) {
//            update.getChatJoinRequest();
//        }
//    }
//
//    @Override
//    public String getBotUsername() {
//        return this.properties.getUsername();
//    }
//
//    @Override
//    public String getBotToken() {
//        return this.properties.getToken();
//    }
//}
